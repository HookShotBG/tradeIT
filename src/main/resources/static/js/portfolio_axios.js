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
        chart: null
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
          axios.get('/findSingleTrade/2').then(response => (this.overview_json = response.data));
        },
        calculateProfitLoss: function(currentPreis, investedPreis){
            pl = currentPreis - investedPreis
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
        createNewPreis : function (){
            this.addPrice().then((result) =>{
                this.latestPrice().then((used) => {
                    this.calculations(this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-1].preis, this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-2].preis);
                    this.drawChart();
                    this.calculateProfitLoss();
                })
            })
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