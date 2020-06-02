Vue.component('detailmodal', {
    template: '<div class="modal-content">\n' +
        '      <div class="modal-header">\n' +
        '        <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n' +
        '          <span aria-hidden="true">&times;</span>\n' +
        '        </button>\n' +
        '        <h3 class="modal-title" id="exampleModalLabel">Microsoft Details</h3>\n' +
        '      </div>\n' +
        '\n' +
        '      <div class="modal-body">\n' +
        '        <form>\n' +
        '          <div class="form-group row">\n' +
        '            <label for="staticPEratio" class="col-sm-4 col-form-label">P/E Ratio:</label>\n' +
        '            <div class="col-sm-8">\n' +
        '              <span id="staticPEratio" >27.91</span>\n' +
        '            </div>\n' +
        '          </div>\n' +
        '          <div class="form-group row">\n' +
        '            <label for="staticMarketcap" class="col-sm-4 col-form-label">Marketcap:</label>\n' +
        '            <div class="col-sm-8">\n' +
        '              <span id="staticMarketcap">1210 Billions</span>\n' +
        '            </div>\n' +
        '          </div>\n' +
        '          <div class="form-group row">\n' +
        '            <label for="static52weekhigh" class="col-sm-4 col-form-label">52 Week High:</label>\n' +
        '            <div class="col-sm-8">\n' +
        '              <span id="static52weekhigh">190.7</span>\n' +
        '            </div>\n' +
        '          </div>\n' +
        '          <div class="form-group row">\n' +
        '            <label for="static52weeklow" class="col-sm-4 col-form-label">52 Week Low:</label>\n' +
        '            <div class="col-sm-8">\n' +
        '              <span id="static52weeklow">118.1</span>\n' +
        '            </div>\n' +
        '          </div>\n' +
        '          <div class="form-group row">\n' +
        '            <label for="staticdivyield" class="col-sm-4 col-form-label">Dividend yield:</label>\n' +
        '            <div class="col-sm-8">\n' +
        '              <span id="staticdivyield">1.27%</span>\n' +
        '            </div>\n' +
        '          </div>\n' +
        '          <div class="form-group row">\n' +
        '            <label for="staticRevenue" class="col-sm-4 col-form-label">Revenue:</label>\n' +
        '            <div class="col-sm-8">\n' +
        '              <span id="staticRevenue" >125.8 Billion USD</span>\n' +
        '            </div>\n' +
        '          </div>\n' +
        '        </form>\n' +
        '      </div>\n' +
        '      <div class="modal-footer">\n' +
        '        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>\n' +
        '      </div>\n' +
        '    </div>'
})