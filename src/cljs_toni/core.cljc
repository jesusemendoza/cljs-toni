(ns cljs-toni.core)

(defn say-hello []
  #?(:clj (println "Hello.....")
     :cljs (js/console.log "Hello from javascript")))

(say-hello)
