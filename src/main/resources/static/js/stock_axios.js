new Vue({
    el: '#container',
    data: {
        json: null
    },
    mounted: function () {
        axios
            .get('/stockX')
            .then(response => (this.json = response.data));


    },
    computed: {
        getCalcDiff: function (){
            this.json.forEach((val) => {
                var aktueller_Preis = val.preis[val.preis.length - 1];
                var zweiterPreis = val.preis[val.preis.length - 2]; //needed for calculations

                //calc preis veränderung in %
                var priceChange = aktueller_Preis.preis*100/zweiterPreis.preis-100;
                priceChange = Math.round((priceChange + Number.EPSILON) * 100) / 100
                console.log(priceChange);
                return priceChange;
            })
        }
    },
    methods: {
        calculations(firstValue, secondValue) {
            var priceChange = firstValue*100/secondValue-100;
            priceChange = Math.round((priceChange + Number.EPSILON) * 100) / 100
            if(priceChange >= 0){
                priceChange = '+' + priceChange;
            }else {
                priceChange = '-' + priceChange;
            }
            return priceChange;
        }
    }
});