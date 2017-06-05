(ns arduino.core
  (:require [firmata.core :as fm]))

(ns-refers 'arduino.core)

(def board (fm/open-serial-board :auto-detect))

(map #(fm/set-pin-mode board % :output) [11 12 13])

(defn off [pin]
 (fm/set-digital board pin :low))

(defn on [pin]
 (fm/set-digital board pin :high))

(defn for [n]
  (take n ((fn fib_seq [x y]
             (lazy-seq (cons x (fib_seq y (+ x y)))))
           1 1)))

(doseq [break (take 100  (cycle (fib 16)))
        pin [12 11 13]]
  (do (on pin)
      (Thread/sleep break)
      (off pin)))


(fib 10)



