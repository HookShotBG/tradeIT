$(document).ready(function () {

    $('#titlesHeld').on('click', '.clickable-row', function (event) {
        $(this).siblings().removeClass("aktimel");
        $(this).toggleClass("aktimel");
    });

    $('#titlesHeld').on('dblclick', '.clickable-row', function (event) {
        $("#detailbutton").click();
    });

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
            $.each(resultSet.preis, function(key, value){
                var t = {
                    x:new Date(value.valid_until),
                    y:value.preis
                }
                xf.push(t);
            });

            console.log(xf);

            var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                theme: "light2",
                title: {
                    text: resultSet.name
                },
                xValueFormatString: "DD MMM, YYYY",
                axisY: {
                    includeZero: false
                },
                data: [{
                    type: "line",
                    indexLabelFontSize: 16,
                    dataPoints: xf[
                        {x: new Date(2020, 03, 1), y: 450},
                        {x: new Date(2020, 03, 2), y: 414},
                        {
                            x: new Date(2020, 03, 3),
                            y: 520,
                            indexLabel: "\u2191 highest",
                            markerColor: "red",
                            markerType: "triangle"
                        },
                        {x: new Date(2020, 03, 4), y: 460},
                        {x: new Date(2020, 03, 5), y: 450},
                        {x: new Date(2020, 03, 6), y: 500},
                        {x: new Date(2020, 03, 7), y: 480},
                        {x: new Date(2020, 03, 8), y: 480},
                        {
                            x: new Date(2020, 03, 9),
                            y: 410,
                            indexLabel: "\u2193 lowest",
                            markerColor: "DarkSlateGrey",
                            markerType: "cross"
                        },
                        {x: new Date(2020, 03, 10), y: 500},
                        {x: new Date(2020, 03, 11), y: 480},
                        {x: new Date(2020, 03, 12), y: 510}
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