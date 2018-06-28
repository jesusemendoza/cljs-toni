(ns cljs-toni.core
  (:require [reagent.core :as reagent]))


(defn app []
  [:div {:class "numbers"}
   (for [i (range 5)]
     ^{:key i}[:h1 {} [* i 5]]) ])

(reagent/render [app] (js/document.querySelector "#root") )
