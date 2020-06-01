var app = new Vue({
    el: '#app',
    data: {
        chart: null,
        chartType: 'bar',
        chartTitle: 'My chart'
    },
    mounted: function () {
        // use this.$refs to get the element with ref="chart"
        // (instead of document.getElementById(...))
        var ctx = this.$refs.chart.getContext('2d');

        this.chart = new Chart(ctx, {
            type: this.chartType,
            data: {
                labels: ["A", "B", "C", "D"],
                datasets: [{
                    label: 'dataset 1',
                    data: [44, 32, 236, 73],
                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
                    borderColor: 'rgba(255,99,132,1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });

    },
    methods: {
        updateChart() {
            this.chart.data.datasets[0].data.push(55)
            this.chart.data.labels.push("E")
            this.chart.update()
        }
    }
});