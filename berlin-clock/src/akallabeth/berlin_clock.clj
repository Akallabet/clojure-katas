(ns akallabeth.berlin-clock
  (:require [clojure.string :as str]))

(defn time? [time] (re-matches #"^([0-1]?[0-9]|2?[0-4])(:[0-5][0-9]){2}$" time))

(defn print-symbol [symbol] (fn [n] (take n (repeat symbol))))
(def print-y (print-symbol "Y"))
(def print-r (print-symbol "R"))
(def print-o (print-symbol "O"))
(defn print-yyr [n] (take n ( cycle ["Y" "Y" "R"])))
(defn calc-seconds [seconds] (if (even? seconds) (print-y 1) (print-o 1)))
(defn calc-full-five [time max symbol] [(symbol (quot time 5)) (print-o (- max (quot time 5)))])
(defn calc-single [time max symbol] [(symbol (mod time 5)) (print-o (- max (mod time 5)))])

(defn highlight-quarters [minutes count] minutes)

(defn time-to-colours [[hours minutes seconds]] (map #(str/join (flatten %))  [
                                                              (calc-seconds seconds)
                                                              (calc-full-five hours 4 print-r)
                                                              (calc-single hours 4 print-r)
                                                              (calc-full-five minutes 11 print-yyr)
                                                              (calc-single minutes 4 print-y)]))

(defn berlin-clock [time]
(cond
  (time? time) (str/join " " (time-to-colours (map read-string (str/split time #":"))))
  :else "Wrong format"
  ))

(comment
  (= (berlin-clock "12:00") "Wrong format")
  (berlin-clock "12:36:01")
  )
