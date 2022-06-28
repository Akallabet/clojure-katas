(ns akallabeth.berlin-clock
  (:require [clojure.string :as str]))

(defn greet
  "Callable entry point to the application."
  [data]
  (println (str "Hello, " (or (:name data) "World") "!")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (greet {:name (first args)}))

(defn time? [time] (re-matches #"^([0-1]?[0-9]|2?[0-4])(:[0-5][0-9]){2}$" time))
(defn time-to-colours [time] (
                              let [formatted (str/split time #":")]))

(defn berlin-clock [time]
(cond
  (time? time) (time-to-colours time)
  :else "Wrong format"
  ))
