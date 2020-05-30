$(document).ready(function () {
    var resultSet = [];
    $.ajax({
        url: "/stockX",
        type: "GET",

        contentType: 'application/json; charset=utf-8',
        success: function (resultData) {
            //append data to table (get first here -> 0 is hardcoded for first)
            //resultData[0]
            //we are now using the last because of the rest service which appends a price
            //to the last element -> graph gets updated as well ^^
            resultSet = resultData[resultData.length - 1];

            //sorting array bc needed (data is fetched from rest but kinda strange)
            resultSet.preis.sort(compare);

            function compare(a, b) {
                // Use toUpperCase() to ignore character casing
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
            $.each(resultSet.preis, function(key, value){
                var ff = new Date(value.valid_until);
                var t = {
                    x: ff,
                    y:value.preis,
                    indexLabel: "gain", markerType: "triangle",  markerColor: "#6B8E23"
                };

                if(key > 0){
                    if(value.preis < resultSet.preis[key-1].preis){
                        t.indexLabel = "loss";
                        t.markerType = "cross";
                        t.markerColor = "tomato";
                    }
                }

                xf.push(t);
            });

            var chart = new CanvasJS.Chart("share_chartContainer", {
                theme: "dark1",
                animationEnabled: true,
                title:{
                    text: resultSet.name
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
            chart.render();

        },
        error: function (jqXHR, textStatus, errorThrown) {
        },

        timeout: 120000,

    });
});