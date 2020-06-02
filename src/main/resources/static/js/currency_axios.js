new Vue({
    el: '#curr',
    data: {
        crypto: [
            {
                id: 1,
                title: 'Bitcoin',
                rate: 'CHF 6543.7',
                dailyChange: '-0.14%'

            },
            {
                id: 2,
                title: 'Ehereum',
                rate: 'CHF 139.50',
                dailyChange: '-1.78%'

            },
            {
                id: 3,
                title: 'Litecoinv',
                rate: 'CHF 39.425',
                dailyChange: '+5.65%'
            }

        ],
        currencies: [
            {
                id: 1,
                title: 'EUR/CHF',
                rate: '1.056',
                dailyChange: '-0.84%'

            },
            {
                id: 2,
                title: 'USD/CHF',
                rate: '0.950',
                dailyChange: '-8.78%'

            },
            {
                id: 3,
                title: 'AUD/CHF',
                rate: '1.425',
                dailyChange: '+2.65%'
            }

        ]

    }
})