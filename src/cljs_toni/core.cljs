(ns cljs-toni.core
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [reagent.core :as reagent]
            [cljs-toni.header :refer (header items-list)]
            [cljs.core.async :refer (chan put! <!)]))


(def EVENTCHANNEL (chan))

;similar to the main state used in react
(def app-state
 (reagent/atom
  {:message "I am the new title"
   :items [{:display "item1"}
           {:display "item2"}
           {:display "item3"}
           {:display "item4"}
           {:display "item5"}]
   :active-item {}}))

(def EVENTS
 {:update-active-item (fn [{:keys [active-item]}]
                        (swap! app-state assoc-in [:active-item] active-item))})


(go
 (while true
   (let [[event-name event-data] (<! EVENTCHANNEL)]
     ((event-name EVENTS) event-data))))

(defn app []
  [:div {:class "app-container"}
    [header (:message @app-state )]
    [items-list EVENTCHANNEL (:items @app-state) (:active-item @app-state)]
   ])

(reagent/render [app] (js/document.querySelector "#root") )
