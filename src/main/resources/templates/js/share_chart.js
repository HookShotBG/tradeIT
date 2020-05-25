$(document).ready(function () {
    var resultSet = [];
    $.ajax({
        url: "/stockX",
        type: "GET",

        contentType: 'application/json; charset=utf-8',
        success: function (resultData) {
            //append data to table
            resultSet = resultData[0];


            console.log(resultSet.preis);

            var xf = [];
            $.each(resultSet.preis, function (key, value) {
                var t = {
                    x: new Date(value.valid_until),
                    y: value.preis
                };
                xf.push(t);
            });

            console.log(xf);



            var chart = new CanvasJS.Chart("share_chartContainer", {
                theme: "dark1",
                animationEnabled: true,
                title:{
                    text: resultSet.name
                },
                axisX: {
                    interval: 1,
                    intervalType: "month",
                    valueFormatString: "MMM"
                },
                axisY:{
                    title: "Price (in USD)",
                    valueFormatString: "$#0"
                },
                data: [{
                    type: "line",
                    markerSize: 12,
                    xValueFormatString: "MMM, YYYY",
                    yValueFormatString: "$###.#",
                    dataPoints: [
                        { x: new Date(2016, 00, 1), y: 61, indexLabel: "gain", markerType: "triangle",  markerColor: "#6B8E23" },
                        { x: new Date(2016, 01, 1), y: 71, indexLabel: "gain", markerType: "triangle",  markerColor: "#6B8E23" },
                        { x: new Date(2016, 02, 1) , y: 55, indexLabel: "loss", markerType: "cross", markerColor: "tomato" },
                        { x: new Date(2016, 03, 1) , y: 50, indexLabel: "loss", markerType: "cross", markerColor: "tomato" },
                        { x: new Date(2016, 04, 1) , y: 65, indexLabel: "gain", markerType: "triangle", markerColor: "#6B8E23" },
                        { x: new Date(2016, 05, 1) , y: 85, indexLabel: "gain", markerType: "triangle", markerColor: "#6B8E23" },
                        { x: new Date(2016, 06, 1) , y: 68, indexLabel: "loss", markerType: "cross", markerColor: "tomato" },
                        { x: new Date(2016, 07, 1) , y: 28, indexLabel: "loss", markerType: "cross", markerColor: "tomato" }
        ]
        }]
        });
            chart.render();

        },
        error: function (jqXHR, textStatus, errorThrown) {
        },

        timeout: 120000,

    });
});