<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>api provisioning</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="/bower_components/Materialize/dist/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/ghpages-materialize.css" type="text/css" rel="stylesheet">
    </head>
    <body>
     
        
            <header>
      <div class="container"><a href="#" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only"><i class="material-icons">menu</i></a></div>
      <ul id="nav-mobile" class="side-nav fixed">
        <li class="logo"><a id="logo-container" href="http://materializecss.com/" class="brand-logo">
            <object id="front-page-logo" type="image/svg+xml" data="res/materialize.svg">Your browser does not support SVG</object></a></li>
        <li class="search">
          <div class="search-wrapper card">
            <input id="search"><i class="material-icons">search</i>
            <div class="search-results"></div>
          </div>
        </li>
        <li class="bold"><a href="about.html" class="waves-effect waves-teal">About</a></li>
        <li class="bold active"><a href="getting-started.html" class="waves-effect waves-teal">Getting Started</a></li>
        <li class="no-padding">
          <ul class="collapsible collapsible-accordion">
            <li class="bold"><a class="collapsible-header  waves-effect waves-teal">CSS</a>
              <div class="collapsible-body">
                <ul>
                  <li><a href="color.html">Color</a></li>
                  <li><a href="grid.html">Grid</a></li>
                  <li><a href="helpers.html">Helpers</a></li>
                  <li><a href="media-css.html">Media</a></li>
                  <li><a href="sass.html">Sass</a></li>
                  <li><a href="shadow.html">Shadow</a></li>
                  <li><a href="table.html">Table</a></li>
                  <li><a href="typography.html">Typography</a></li>
                </ul>
              </div>
            </li>
            <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Components</a>
              <div class="collapsible-body">
                <ul>
                  <li><a href="badges.html">Badges</a></li>
                  <li><a href="buttons.html">Buttons</a></li>
                  <li><a href="breadcrumbs.html">Breadcrumbs</a></li>
                  <li><a href="cards.html">Cards</a></li>
                  <li><a href="chips.html">Chips</a></li>
                  <li><a href="collections.html">Collections</a></li>
                  <li><a href="footer.html">Footer</a></li>
                  <li><a href="forms.html">Forms</a></li>
                  <li><a href="icons.html">Icons</a></li>
                  <li><a href="navbar.html">Navbar</a></li>
                  <li><a href="pagination.html">Pagination</a></li>
                  <li><a href="preloader.html">Preloader</a></li>
                </ul>
              </div>
            </li>
            <li class="bold"><a class="collapsible-header  waves-effect waves-teal">JavaScript</a>
              <div class="collapsible-body">
                <ul>
                  <li><a href="collapsible.html">Collapsible</a></li>
                  <li><a href="dialogs.html">Dialogs</a></li>
                  <li><a href="dropdown.html">Dropdown</a></li>
                  <li><a href="media.html">Media</a></li>
                  <li><a href="modals.html">Modals</a></li>
                  <li><a href="parallax.html">Parallax</a></li>
                  <li><a href="pushpin.html">Pushpin</a></li>
                  <li><a href="scrollfire.html">ScrollFire</a></li>
                  <li><a href="scrollspy.html">Scrollspy</a></li>
                  <li><a href="side-nav.html">SideNav</a></li>
                  <li><a href="tabs.html">Tabs</a></li>
                  <li><a href="transitions.html">Transitions</a></li>
                  <li><a href="waves.html">Waves</a></li>
                </ul>
              </div>
            </li>
          </ul>
        </li>
        <li class="bold"><a href="http://materializecss.com/mobile.html" class="waves-effect waves-teal">Mobile</a></li>
        <li class="bold"><a href="showcase.html" class="waves-effect waves-teal">Showcase</a></li>
      </ul>
    </header>
    <main><div class="section" id="index-banner">
  <div class="container">
    <div class="row">
      <div class="col s12 m9">
        <h1 class="header center-on-small-only">Getting Started</h1>
        <h4 class ="light red-text text-lighten-4 center-on-small-only">Learn how to easily start using Materialize in your website.</h4>
      </div>
      <div class="col s12 m3">
        <!-- BuySellAds Zone Code -->
        <div class="buysellads-header center-on-small-only">
          <!-- CarbonAds Zone Code -->
          <script async type="text/javascript" src="//cdn.carbonads.com/carbon.js?zoneid=1673&serve=C6AILKT&placement=materializecss" id="_carbonads_js"></script>
        </div>
        <!-- End BuySellAds Zone Code -->
      </div>
    </div>
  </div>
</div>

<div class="container">
  <!--  Outer row  -->
  <div class="row">

    <div class="section col s12 m9 l10">
      <div id="download" class="row scrollspy">
          <h2 class="col s12 header">Download</h2>
        <p class="caption col s12">Materialize comes in two different forms. You can select which version you want depending on your preference and expertise. To start using Materialize, all you have to do is download one of the options below.</p>

        <div class="col s12 m6">
          <p class="promo-caption">Materialize</p>
          <p>This is the standard version that comes with both the minified and unminified CSS and JavaScript files. This option requires little to no setup. Use this if you are unfamiliar with Sass.</p>
          <a id="download-source" class="btn waves-effect waves-light" href="http://materializecss.com/bin/materialize-v0.97.6.zip">Materialize<i class="material-icons right">file_download</i></a>
        </div>
        <div class="col s12 m6">
          <p class="promo-caption">Sass</p>
          <p>This version contains the source SCSS files. By choosing this version you have more control over which components to include. You will need a Sass compiler if you choose this option.</p>
          <a id="download-sass" class="btn waves-effect waves-light" href="http://materializecss.com/bin/materialize-src-v0.97.6.zip">Source<i class="material-icons right">file_download</i></a>
        </div>
        <div class="col s12">
          <br>
          <p class="promo-caption">CDN</p>
          <p>You can find all the versions of the CDN at <a href="https://cdnjs.com/libraries/materialize">cdnjs</a>.</p>
          <pre><code class="language-markup">
  &lt;!-- Compiled and minified CSS -->
  &lt;link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">

  &lt;!-- Compiled and minified JavaScript -->
  &lt;script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js">&lt;/script>
          </code></pre>
        </div>
        <div class="col s12">
          <br>
          <p class="promo-caption">NPM</p>
          <p>You can also get the latest release using NPM. This release contains source files as well as the compiled CSS and JavaScript files.</p>
          <pre><code class="language-bash">
  npm install materialize-css
          </code></pre>
        </div>
        <div class="col s12">
          <br>
          <p class="promo-caption">Bower</p>
          <p>You can also get the latest release using bower. This release contains source files as well as the compiled CSS and JavaScript files.</p>
          <pre><code class="language-bash">
  bower install materialize
          </code></pre>
        </div>
      </div>

      <div id="download-thanks" class="row">
        <h2 class="col s12 header">Thanks for Downloading!</h2>
        <p class="caption col s12">We hope you find Materialize useful in your next project. We would appreciate if you helped us spread the word about Materialize on our Social Media. Also if you want to support the development, you can donate to us.</p>
        <div class="row">
          <div class="col l3 s12 center">
            <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
            <input type="hidden" name="cmd" value="_s-xclick">
            <input type="hidden" name="encrypted" value="-----BEGIN PKCS7-----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-----END PKCS7-----
            ">
            <button class="btn waves-effect waves-light red lighten-3" type="submit" name="action" alt="PayPal - The safer, easier way to pay online!">Donate Now
            </button>
            </form>
            <br>
          </div>
          <div class="col l3 s12 center" style="overflow: hidden;">
            <iframe src="http://ghbtns.com/github-btn.html?user=dogfalo&repo=materialize&type=watch&count=true&size=large" allowtransparency="true" frameborder="0" scrolling="0" width="170" height="30"></iframe>
            <br>
          </div>
          <div class="col l3 s12 center" style="overflow: hidden;">
            <a href="https://twitter.com/MaterializeCSS" class="twitter-follow-button" data-show-count="true" data-size="large" data-dnt="true">Follow @MaterializeCSS</a>
            <br>
          </div>
          <div class="col l3 s12 center" style="overflow: hidden;">
            <div class="g-follow" data-annotation="bubble" data-height="24" data-href="https://plus.google.com/108619793845925798422" data-rel="publisher"></div>
            <br>
          </div>
        </div>
      </div>

      <div id="setup" class="row scrollspy">
        <div class="col s12">
          <h2 class="header">Setup</h2>
          <h4 >Project Structure</h4>
          <p>After downloading, extract the files into the directory where your website is located. Your directory will look something like this.</p>
          <p>You'll notice that there are two sets of the files. The <code class="language-markup">min</code> means that the file is "compressed" to reduce load times. These minified files are usually used in production while it is better to use the unminified files during development.</p>

          <pre><code class="language-markup directory-markup">
  MyWebsite/
  |--css/
  |  |--materialize.css
  |
  |--fonts/
  |  |--roboto/
  |
  |--js/
  |  |--materialize.js
  |
  |--index.html
          </code></pre>
        </div>
      <div class="col s12">
        <h4>HTML Setup</h4>
        <p>Next you just have to make sure you link the files properly in your webpage. Generally it is wise to import javascript files at the end of the body to reduce page load time. Follow the example below on how to import Materialize into your webpage.</p>
        <p> One last thing to note is that you have to import jQuery before importing materialize.js!</p>
        <pre><code class="language-markup">
  &lt;!DOCTYPE html>
  &lt;html>
    &lt;head>
      &lt;!--Import Google Icon Font-->
      &lt;link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      &lt;!--Import materialize.css-->
      &lt;link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

      &lt;!--Let browser know website is optimized for mobile-->
      &lt;meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    &lt;/head>

    &lt;body>
      &lt;!--Import jQuery before materialize.js-->
      &lt;script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js">&lt;/script>
      &lt;script type="text/javascript" src="js/materialize.min.js">&lt;/script>
    &lt;/body>
  &lt;/html>
        </code></pre>
      </div>
    </div>

    <div id="templates" class="row scrollspy">
      <h2 class="col s12 header">Templates</h2>
      <p class="caption col s12">We have created some starter templates so you can easily start designing your website with minimal setup up time. Browse through our collection and download your best fit. </p>

      <div class="col s12 m6">
        <p class="promo-caption">Starter Template</p>
        <a href="templates/starter-template/preview.html"><img class="z-depth-1" style="width: 100%;" src="images/starter-template.gif"></a>
        <p>This is the simplest starter page with a Header, Call-to-Action, and Icon Features. </p>
        <a class="btn waves-effect waves-light" href="templates/starter-template/preview.html">Demo<i class="material-icons right">search</i></a>
        <a class="btn waves-effect waves-light" href="templates/starter-template.zip">Download<i class="material-icons right">file_download</i></a>
      </div>

      <div class="col s12 m6">
        <p class="promo-caption">Parallax Template</p>
        <a href="templates/parallax-template/preview.html"><img class="z-depth-1" style="width: 100%;" src="images/parallax-template.jpg"></a>
        <p>This is the simplest starter page with a Header, Call-to-Action, and Icon Features. </p>
        <a class="btn waves-effect waves-light" href="templates/parallax-template/preview.html">Demo<i class="material-icons right">search</i></a>
        <a class="btn waves-effect waves-light" href="templates/parallax-template.zip">Download<i class="material-icons right">file_download</i></a>
      </div>
    </div>


      <!-- Third Party Options -->
      <div id="third-party-options" class="row scrollspy">
        <div class="col s12">
          <h2 class="header">Third-party Options</h2>
          <p class="caption">There are a few community-made options for you to easily include Materialize in your project. Keep in mind these are untested and may be out-of-date.</p>
          <p class="promo-caption">Ruby Gem</p>
          <p>See <a href="https://github.com/mkhairi/materialize-sass">here</a> for documentation on this gem.</p>
          <pre><code class="language-bash">
  gem 'materialize-sass'
          </code></pre>
          <p class="promo-caption">Meteor Package</p>
          <pre><code class="language-bash">
  meteor add materialize:materialize
          </code></pre>
          <p class="promo-caption">Ember Package</p>
          <pre><code class="language-bash">
  # install via npm
  $ npm install ember-cli-materialize --save-dev
  # make ember-cli fetch internal dependencies
  $ ember g ember-cli-materialize
          </code></pre>

      </div>
    </div>

    <div id="sass" class="row scrollspy">
      <div class="col s12">
        <h2 class="header">Sass Setup</h2>
        <p class="caption">This section is only relevant if you chose to download the Sass version of Materialize.</p>
        <h4>Compiling Sass</h4>
        <p>Instead of having a css folder, you will find that the download instead contains many .scss files which contain the styles of individual components. Unfortunately, the browser cannot interpret Sass, so you must have your Sass compiler compile the scss/materialize.scss into a regular CSS file. At this point you can link this newly outputted file in your HTML page.</p>

        <pre><code class="language-markup directory-markup">
  MyWebsite/
  |--css/
  |  |--materialize.css &lt;-- compiled from scss/materialize.scss
  |
  |--fonts/
  |  |--roboto/
  |
  |--js/
  |  |--materialize.js
  |
  |--scss/
  |  |--materialize.scss
  |  |--components/
  |
  |--index.html
        </code></pre>
      </div>
    </div>

    </div>
    <!-- Table of contents -->
      <div class="col hide-on-small-only m3 l2">
        <div class="toc-wrapper">
          <div style="height: 1px;">
          <ul class="table-of-contents">
            <li><a href="#download">Download</a></li>
            <li><a href="#setup">Setup</a></li>
            <li><a href="#templates">Templates</a></li>
            <li><a href="#third-party-options">Third-party Options</a></li>
            <li><a href="#sass">Sass</a></li>
          </ul>
          </div>
        </div>
      </div>

  </div>
</div>

    </main>    <footer class="page-footer">
      <div class="container">
        <div class="row">
          <div class="col l4 s12">
            <h5 class="white-text">Help Materialize Grow</h5>
            <p class="grey-text text-lighten-4">We hope you have enjoyed using Materialize! If you feel Materialize has helped you out and want to support the team, send us over a donation! Any amount would help support and continue development on this project and is greatly appreciated.</p>
            <form id="paypal-donate" action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
<input type="hidden" name="cmd" value="_s-xclick">
<input type="hidden" name="encrypted" value="-----BEGIN PKCS7-----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-----END PKCS7-----
">
<button class="btn waves-effect waves-light red lighten-3" type="submit" name="action" alt="PayPal - The safer, easier way to pay online!">Donate Now
</button>
</form>

          </div>
          <div class="col l4 s12">
            <h5 class="white-text">Join the Discussion</h5>
            <p class="grey-text text-lighten-4">We have a Gitter chat room set up where you can talk directly with us. Come in and discuss new features, future goals, general problems or questions, or anything else you can think of.</p>
            <a class="btn waves-effect waves-light red lighten-3" target="_blank" href="https://gitter.im/Dogfalo/materialize">Chat</a>
          </div>
          <div class="col l4 s12" style="overflow: hidden;">
            <h5 class="white-text">Connect</h5>
            <iframe src="http://ghbtns.com/github-btn.html?user=dogfalo&repo=materialize&type=watch&count=true&size=large" allowtransparency="true" frameborder="0" scrolling="0" width="170" height="30"></iframe>
            <br>
            <a href="https://twitter.com/MaterializeCSS" class="twitter-follow-button" data-show-count="true" data-size="large" data-dnt="true">Follow @MaterializeCSS</a>
            <br>
            <div class="g-follow" data-annotation="bubble" data-height="24" data-href="https://plus.google.com/108619793845925798422" data-rel="publisher"></div>
          </div>
        </div>
      </div>
      <div class="footer-copyright">
        <div class="container">
        © 2014-2016 Materialize, All rights reserved.
        <a class="grey-text text-lighten-4 right" href="https://github.com/Dogfalo/materialize/blob/master/LICENSE">MIT License</a>
        </div>
      </div>
    </footer>
        
        
        
        
        
        
        
        
        
        
        
        
        
        <script src="bower_components/jquery/dist/jquery.js"></script>
        <script src="bower_components/Materialize/dist/js/materialize.js"></script>
    </body>
</html>
