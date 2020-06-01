Vue.component('navigation', {
    template: '<div class="col-sm-3 sidenav hidden-xs">\n' +
        '      <h2>TradeIT</h2>\n' +
        '      <ul class="nav nav-pills nav-stacked">\n' +
        '        <li><a href="markets">Markets</a></li>\n' +
        '        <li><a href="portfolio">Portfolio</a></li>\n' +
        '        <li class="disabled"><a href="#section2">Watchlist</a></li>\n' +
        '        <li class="disabled"><a href="#section3">Social</a></li>\n' +
        '        <li class="disabled"><a href="#section3">Settings</a></li>\n' +
        '        <li><a href="/logout" method="post">Sign Out</a></li>\n' +
        '      </ul><br>\n' +
        '    </div>'
})

