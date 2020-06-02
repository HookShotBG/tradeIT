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
            console.log(firstValue);
            console.log(secondValue);
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
        createNewPreis : async function (event){
            const newPreis = Math.floor((Math.random() * 100) + 1);
            const postRequest = 'http://localhost:8080/preis/' + newPreis;
            axios.post(postRequest);
            await axios.get('/preis/latestPreis').then(response => (this.json[this.json.length-1].preis.push(response.data))).resolve(this.calculations(this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-1].preis, this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-2].preis));



            //this.calculations(this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-1].preis, this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-2].preis);

        },
        something() {
            return new Promise((resolve) => {
                resolve(axios.get('/preis/latestPreis')).then(response => (this.json[this.json.length-1].preis.push(response.data))).then(this.calculations(this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-1].preis, this.json[this.json.length-1].preis[this.json[this.json.length-1].preis.length-2].preis));
            });
        },
        anotherMethod() {
            this.something('blah').then((data) => {
                this.foo = data;
            });
        }
    }
});