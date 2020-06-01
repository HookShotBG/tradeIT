new Vue({
    el: '#crypto',
    data: {
        currencies: [
            {
                id: 1,
                title: 'Bitcoin',
                rate: 'CHF 6543.79',
                dailyChange: '-0.14%'

            },
            {
                id: 2,
                title: 'Ehereum',
                rate: 'CHF 139.5',
                dailyChange: '-1.78%'

            },
            {
                id: 3,
                title: 'Litecoinv',
                rate: 'CHF 39.4258',
                dailyChange: '+5.65%'
            }

        ]
    }
})