(ns cljs-toni.header)

(defn header [message]
  [:div {}
   [:h1 {:class "header"} message]])
