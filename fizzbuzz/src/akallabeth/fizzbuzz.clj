(ns akallabeth.fizzbuzz
  (:gen-class))

(defn greet
  "Callable entry point to the application."
  [data]
  (println (str "Hello, " (or (:name data) "World") "!")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (greet {:name (first args)}))

(defn div-by-n? [n] (fn [x] (= 0 (rem x n))))
(def div-by-3? (div-by-n? 3))
(def div-by-5? (div-by-n? 5))
(def div-by-15? (div-by-n? 15))

(defn fizzbuzz-n [n] (
                        cond
                        (div-by-15? n) "fizzbuzz"
                        (div-by-3? n) "fizz"
                        (div-by-5? n) "buzz"
                        :else n))

(defn fizzbuzz
  ([min max] (map fizzbuzz-n (range min max)))
  ([max] (fizzbuzz 1 max))
  )

(defn fizzbuzz-lazy
  ([min max] (take max (iterate inc min))))


(comment
  ((div-by-n? 2) 10)
  (div-by-3? 6)
  (div-by-5? 10)
  (div-by-15? 30)
  (fizzbuzz-n 3)
  (fizzbuzz-n 5)
  (fizzbuzz-n 15)
  (fizzbuzz-n 4)
  (fizzbuzz 20)
  (fizzbuzz 5 23)
  (fizzbuzz-lazy 1 5)
 )
