Vue.component('sellmodal', {
    template: '<div class="modal-content">\n' +
        '            <div class="modal-header">\n' +
        '                <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n' +
        '                    <span aria-hidden="true">&times;</span>\n' +
        '                </button>\n' +
        '                <h3 class="modal-title" id="sellModalArea">Sell</h3>\n' +
        '            </div>\n' +
        '\n' +
        '            <div class="modal-body">\n' +
        '                <form>\n' +
        '                    <form>\n' +
        '                        <div class="form-group row">\n' +
        '                            <label for="staticSymbol" class="col-sm-4 col-form-label">Symbol:</label>\n' +
        '                            <div class="col-sm-8">\n' +
        '                                <span id="staticSymbol">VUSA</span>\n' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                        <div class="form-group row">\n' +
        '                            <label for="staticPrice" class="col-sm-4 col-form-label">Price:</label>\n' +
        '                            <div class="col-sm-8">\n' +
        '                                <span id="staticPrice">48.10 CHF</span>\n' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                        <div class="form-group row">\n' +
        '                            <label for="staticValor" class="col-sm-4 col-form-label">Valor:</label>\n' +
        '                            <div class="col-sm-8">\n' +
        '                                <span id="staticValor">1298739</span>\n' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                        <div class="form-group row">\n' +
        '                            <label for="staticZeit" class="col-sm-4 col-form-label">Time:</label>\n' +
        '                            <div class="col-sm-8">\n' +
        '                                <span id="staticZeit">10:06:15</span>\n' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                        <div class="form-group row">\n' +
        '                            <label for="inputUnits" class="col-sm-4 col-form-label">Units:</label>\n' +
        '                            <div class="col-sm-8">\n' +
        '                                <input type="number" class="form-control" id="inputUnits" placeholder="Units">\n' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                        <div class="form-group row">\n' +
        '                            <label for="inputLimite" class="col-sm-4 col-form-label">Limit:</label>\n' +
        '                            <div class="col-sm-8">\n' +
        '                                <input type="number" class="form-control" id="inputLimite" placeholder="Optional">\n' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                        <div class="form-group row">\n' +
        '                            <label for="inputStoploss" class="col-sm-4 col-form-label">Stop Loss:</label>\n' +
        '                            <div class="col-sm-8">\n' +
        '                                <input type="number" class="form-control" id="inputStoploss" placeholder="Optional">\n' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                        <div class="form-group row">\n' +
        '                            <label for="inputTakeprofit" class="col-sm-4 col-form-label">Take Profit:</label>\n' +
        '                            <div class="col-sm-8">\n' +
        '                                <input type="number" class="form-control" id="inputTakeprofit" placeholder="Optional">\n' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                        <div class="form-group row">\n' +
        '                            <label for="staticGegenwert" class="col-sm-4 col-form-label">Equivalent:</label>\n' +
        '                            <div class="col-sm-8">\n' +
        '                                <span id="staticGegenwert">2000 USD</span>\n' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                    </form>\n' +
        '                </form>\n' +
        '            </div>\n' +
        '            <div class="modal-footer">\n' +
        '                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>\n' +
        '                <button type="button" class="btn btn-primary" data-dismiss="modal">Sell</button>\n' +
        '            </div>\n' +
        '        </div>'
})