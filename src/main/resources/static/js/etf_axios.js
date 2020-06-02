new Vue({
    el: '#etf',
    data: {
        etfs: [
            {
                id: 1,
                title: 'BOTZ',
                rate: 'CHF 17.45',
                dailyChange: '+1.14%',
                exchange: "NSDQ"

            },
            {
                id: 2,
                title: 'ROBO',
                rate: 'CHF 112.5',
                dailyChange: '-1.90%',
                exchange: "NSDQ"

            },
            {
                id: 3,
                title: 'IBUY',
                rate: 'CHF 139.80',
                dailyChange: '+18.75%',
                exchange: "SIX"
            }

        ]
    }
})