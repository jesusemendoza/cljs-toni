(ns cljs-toni.core
  (:require [reagent.core :as reagent]
            [cljs-toni.header :refer (header)]))

;similar to the main state used in react
(def app-state
  (reagent/atom
   {:message "hello from app state"
    :items [{:display "item1"}
            {:display "item2"}
            {:display "item3"}
            {:display "item4"}
            {:display "item5"}]
    :active-item {}}))

(defn items-list [items active-item]
  [:div {:class "item-list"}
    (for [item (:items @app-state)]
      ^{:key (rand 30)}
          [:div {:class (if (= active-item item) "item active" "item")}
            [:h1
             {:on-click (fn [event] (swap! app-state assoc-in [:active-item] item))}
             (:display item)]])])

(defn app []
  [:div {:class "numbers"}
    [header (:message @app-state )]
    [items-list (:items @app-state) (:active-item @app-state)]
   ])

(reagent/render [app] (js/document.querySelector "#root") )
