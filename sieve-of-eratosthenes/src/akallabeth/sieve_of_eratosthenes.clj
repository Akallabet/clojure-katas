(ns akallabeth.sieve-of-eratosthenes
  (:gen-class))

;;sieve (x:xs) = x : sieve [y | y <- xs, mod y x /= 0]

(defn sieve [[head & tail]]
  (lazy-seq
   (cons head
         (sieve (filter #(not (zero? (mod % head))) tail)))))

(def primes (sieve (drop 2 (range))))

(comment
  (take 10 primes)
  )
