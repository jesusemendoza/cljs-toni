(defproject cljs-toni "0.1.0-SNAPSHOT"

  :description "FIXME: write description"

  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :main cljs-toni.core

  :cljsbuild {:builds [{
                      :id "dev"
                      :source-paths ["src"]
                      ;:figwheel true
                      :compiler
                          {
                           :optimizations :none
                           :output-to "resources/public/javascripts/dev.js"
                           :output-dir "resources/public/javascripts/cljs-dev/"
                           :pretty-print true
                           :source-map true
                           }}
                       ; {
                       ;  :id "production"
                       ;  :source-paths ["src/cljs_toni"]
                       ;  :compiler
                       ;    {
                       ;     :optimizations :none
                       ;     :output-to "resources/pubic/javascripts/production.js"
                       ;     :output-dir "resources/public/javascripts/cljs-production"
                       ;     :pretty-print false
                       ;     :source-map true}}
                       ]}

  :plugins [[lein-cljsbuild "1.1.7"]]
            ;[lein-figwheel "0.5.16"]

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 [reagent "0.8.1"]
                 ])
