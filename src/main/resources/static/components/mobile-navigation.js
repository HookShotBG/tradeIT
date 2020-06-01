Vue.component('mobile-navigation', {
    template: '<nav class="navbar navbar-inverse visible-xs">\n' +
        '  <div class="container-fluid">\n' +
        '    <div class="navbar-header">\n' +
        '      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">\n' +
        '        <span class="icon-bar"></span>\n' +
        '        <span class="icon-bar"></span>\n' +
        '        <span class="icon-bar"></span>\n' +
        '      </button>\n' +
        '      <a class="navbar-brand" href="#">TradeIT</a>\n' +
        '    </div>\n' +
        '    <div class="collapse navbar-collapse" id="myNavbar">\n' +
        '      <ul class="nav navbar-nav">\n' +
        '        <li><a href="markets">Markets</a></li>\n' +
        '        <li><a href="portfolio">Portfolio</a></li>\n' +
        '        <li class="disabled"><a href="#section2">Watchlist</a></li>\n' +
        '        <li class="disabled"><a href="#section3">Social</a></li>\n' +
        '        <li class="disabled"><a href="#section3">Settings</a></li>\n' +
        '        <li><a href="/logout" method="post">Sign Out</a></li>\n' +
        '      </ul>\n' +
        '    </div>\n' +
        '  </div>\n' +
        '</nav>'
})

