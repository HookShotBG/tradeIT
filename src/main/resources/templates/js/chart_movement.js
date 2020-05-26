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

            var xf = [];
            $.each(resultSet.preis, function(key, value){
                var ff = new Date(value.valid_until);
                var t = {
                    x: ff,
                    y:value.preis
                }
                xf.push(t);
            });

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