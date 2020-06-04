new Vue({
    el: '#container',
    data: {
        json: null,
        overview_json: null,
        classes: {
            isLoss: false,
            isProfit: false
        },
        resultSet: null,
        chart: null,
        rate: null,
        pl: null,
        plp: null,
        inv: null,
        uni: null,
        invat: null
    },
    mounted: function () {
        this.getPortfolioData();
        this.getOverviewData();
        this.drawChart();
    },
    methods: {
        getPortfolioData: function(){
            axios
                .get('/stockX')
                .then(response => (this.json = response.data));
        },
        getOverviewData: function(){
          axios.get('/findSingleTrade/2').then((response) => {
              this.overview_json = response.data;
              this.rate = this.overview_json.currentPreis;
              this.inv=this.overview_json.invested;
              this.invat=this.overview_json.preis;
              this.uni=this.overview_json.units;
              this.pl = this.calculateProfitLoss(this.overview_json.currentPreis, this.overview_json.preis);
              this.plp = this.calculations(this.overview_json.currentPreis, this.overview_json.preis);
          });
        },
        calculateProfitLoss: function(currentPreis, investedPreis){
            var pl =  currentPreis - investedPreis;
            pl = Math.round((pl + Number.EPSILON) * 100) / 100
            if(pl >= 0){
                pl = '+' + pl;
                this.classes.isProfit = false;
                this.classes.isLoss= true;
            }else {
                this.classes.isProfit = true;
                this.classes.isLoss = false;
            }
            return pl
        },
        calculations: function (firstValue, secondValue) {
            var priceChange = firstValue*100/secondValue-100;
            priceChange = Math.round((priceChange + Number.EPSILON) * 100) / 100
            if(priceChange >= 0){
                priceChange = '+' + priceChange;
                this.classes.isProfit = false;
                this.classes.isLoss= true;
            }else {
                this.classes.isProfit = true;
                this.classes.isLoss = false;
            }
            return priceChange;
        },
        // der add preis button ist ein bisschen mächtiger als
        //er scheint -> grundsätzlich könnte man meinen
        //der fügt einen preis einer liste hinzu und gut ist
        //was diese funktion eigentlihc macht ist mehr:

        //bevor wir auf die funktion eingehen, einen kurzen input
        //wie es aufgebaut ist
        //die daten für das portfolio werden vorwiegend aus der
        //json variable geholt, welche in mount initialisiert wird
        //die daten werden anhand eines axios get requests
        //geholt

        //zur funktion:

        //die funktion: erstellt eine neue js Promise welche in addPrice
        //ausgeführt wird
        //die ausführung besteht aus der generation aus einem neuen
        //preis mit math random
        //dieser wird nachfolgend mit einem post call in der db
        //gespeichert -> auf der url http://localhost:8080/preis/XX
        //befindet sich ein requestmapping von einem restcontroller
        //nachdem die erste promise erfüllt ist, wird eine
        //zweite promise ausgeührt
        //bei dieser handelt es sich um das fetchen vom aktuellen
        //preis. folglich wird erneut ein axios command ausgeführt
        //dieses mal aber mit einem get request und nicht post
        //die neuen daten überschreiben, sobald die promise erfüllt ist
        //this.json mti den aktuellen werten.

        //diese werte müssen auch in der view angepasst werden, daher werden sobald die fetch
        //promise fulfilled ist die neuen preise berechnet werden
        //
        //bei der ersten methode calculations wird die preisdifferenz pro tag berechnet
        // einfacherheitshalber wird nur der letzte aktienhandel angepasst
        //da es sich bei der json variable um ein array an objekten handelt,
        //wird hier das letzte, wird mit diesem befehl das letzte element im array geholt
        //davon soll der preis genommen werden. da es sich beim preis ebenfalls um eine liste
        //handelt, muss auch bei diesem das letzte element genommen werden, als auch
        //das zweitletzte, um die tagesveränderung zu berechnen
        //
        //die drawChart methode muss aufgrund des neuen elements in this.json erneut
        //aufgerufen werden, um das chart neu zu erstellen
        //denn die daten werden ebenfalls vom json geladen, und dieses hat sich aktualisiert
        //
        //die variable currentPreis wurde der lesbarkeitshalber erstellt, dabei handelt es
        //sich um den aktuellen preis, welcher neu hinzugefügt wurde
        //da dieser grundsätzlich in solch einer applikation nciht intern generiert wird
        //haben wir diesen nicht als globale variable definiert sondern holen ihn über
        //das json
        //
        //nachdem werden die einzelnen variablen, welche auch im portfolio referenziert
        //werden überschrieben und angepasst
        //
        //dabei handelt es sich bei calculate ProfitLoss um die berechnung vom aktuellen
        //wert der aktie zum einstandspreis des benutzers -> was wie marc gezeigt hat
        //entweder positiv oder negativ ist
        //
        //zum schluss wird calculations erneut ausgeführt, dies mal aber im zusammenhang
        //mit dem aktuellen preis und einstandspreis und nicht um die tagesveränderung
        //zu berechnen
        createNewPreis : function (){
            this.addPrice().then((result) =>{
                this.latestPrice().then((used) => {
                    this.calculations(this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-1].preis, this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-2].preis);
                    this.drawChart();
                    const currentPreis = this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-1].preis;
                    this.rate = currentPreis;
                    this.pl = this.calculateProfitLoss(currentPreis, this.overview_json.preis);
                    this.plp = this.calculations(currentPreis, this.overview_json.preis);
                });
            });

        },
        addPrice(){
            const newPreis = Math.floor((Math.random() * 100) + 1);
            const postRequest = 'http://localhost:8080/preis/' + newPreis;
            return axios.post(postRequest);
        },
        latestPrice (){
            return axios.get('/preis/latestPreis').then(response => (this.json[this.json.length-1].preis.push(response.data)));
        },
        drawChart(){
            axios
                .get('/stockX')
                .then((response) => {
                    this.resultSet = response.data;

                    this.resultSet[1].preis.sort(compare);

                    function compare(a, b) {
                        var date1 = a.idPreis;
                        var date2 = b.idPreis;
                        var comparison = 0;
                        if (date1 > date2) {
                            comparison = 1;
                        } else if (date1 < date2) {
                            comparison = -1;
                        }
                        return comparison;
                    }

                    var xf = [];
                    this.resultSet[1].preis.forEach((value, key) => {
                        var ff = new Date(value.valid_until);
                        var t = {
                            x: ff,
                            y:value.preis,
                            indexLabel: "", markerType: "circle",  markerColor: "#6B8E23"
                        };

                        if(key > 0){
                            if(value.preis < this.resultSet[1].preis[key-1].preis){
                                t.indexLabel = "";
                                t.markerType = "circle";
                                t.markerColor = "tomato";
                            }
                        }
                        xf.push(t);
                    })
                    this.chart = new CanvasJS.Chart("share_chartContainer", {
                        theme: "light1",
                        animationEnabled: true,
                        title:{
                            text: this.resultSet[1].name
                        },
                        axisX: {
                            interval: 1,
                            intervalType: "day",
                            valueFormatString: "DD"
                        },
                        axisY:{
                            title: "Price (in CHF)",
                            valueFormatString: "$#0"
                        },
                        data: [{
                            type: "line",
                            markerSize: 12,
                            xValueFormatString: "MMM, YYYY",
                            yValueFormatString: "$###.#",
                            dataPoints: xf
                        }]
                    });
                    this.chart.render();

                });
        }
    }

});