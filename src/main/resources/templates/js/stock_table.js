$(document).ready(function () {
    $.ajax({
        url: "/stockX",
        type: "GET",

        contentType: 'application/json; charset=utf-8',
        success: function (resultData) {
            //append data to table
            $.each(resultData, function (key, value) {
                // value is the object with all the data (aka where magic happens)
                var aktueller_Preis = value.preis[value.preis.length - 1];
                var zweiterPreis = value.preis[value.preis.length - 2]; //needed for calculations

                //calc preis veränderung in %
                var priceChange = aktueller_Preis.preis*100/zweiterPreis.preis-100;
                priceChange = Math.round((priceChange + Number.EPSILON) * 100) / 100

                var klasse = "";
                //zuweisung der klasse nach +/-
                if(priceChange > 0){
                    klasse = "pProfit"
                    priceChange = '+'+priceChange+'%';
                }else{
                    klasse = "pLoss"
                    priceChange = priceChange+'%';
                }
                tableRow = $('<tr>').append(
                    $('<td>').text(value.name),
                    $('<td>').text(aktueller_Preis.preis),
                    $('<td>').text(priceChange).addClass(klasse),
                    $('<td>').text(value.boersenplatz.kuerzel),
                    $('<td><button type="button" class="buyButton" data-toggle="modal" data-target="#buyModal">Buy</button></td>')
                ).appendTo('#stockdataTable');

            });

        },
        error: function (jqXHR, textStatus, errorThrown) {
        },

        timeout: 120000,
    });
});