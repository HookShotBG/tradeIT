new Vue({
    el: '#container',
    data: {
        json: null,
        overview_json: null,
        classes: {
            isLoss: false,
            isProfit: false
        }
    },
    mounted: function () {
        this.getPortfolioData();
        this.getOverviewData();
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
        calculations: function (firstValue, secondValue) {
            console.log("power " + this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-1].preis);
           let priceChange = firstValue*100/secondValue-100;
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
        overViewCalcs: function(){

        },
        createNewPreis : function (event){
            //create new preis between 1 and 100
            const newPreis = Math.floor((Math.random() * 100) + 1);
            const postRequest = 'http://localhost:8080/preis/' + newPreis;
            axios.post(postRequest);
            axios.get('/preis/latestPreis').then(response => (this.json[this.json.length-1].preis.push(response.data))).then(this.calculations(this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-1].preis, this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-2].preis));

        }
    }
});