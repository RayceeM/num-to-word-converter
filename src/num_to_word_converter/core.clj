(ns num-to-word-converter.core
  (:require [clojure.edn :as edn]))

(def single-numbers
  {1 "one"
   2 "two"
   3 "three"
   4 "four"
   5 "five"
   6 "six"
   7 "seven"
   8 "eight"
   9 "nine"
   10 "ten"
   11 "elleven"
   12 "twelve"
   13 "thirteen"
   14 "fourteen"
   15 "fifteen"
   16 "sixteen"
   17 "seventeen"
   18 "eighteen"
   19 "nineteen"})

(def multiples-of-ten
  [" "
   " "
   "twenty "
   "thirty "
   "fourty "
   "fifty "
   "sixty "
   "seventy "
   "eighty "
   "ninety "])

(defn num->digits [num]
  (->> (str num)
       seq
       (map str)
       (map read-string)
       count))

(defn number-to-words [num]
  (if (> num 19)
    (str (get multiples-of-ten (quot num 10))
         (get single-numbers (rem num 10)))
    (get single-numbers num)))

(defn convert-number-to-words
  [num]
  (let [number-count (num->digits num)]
    (case number-count
      (or 1 2) (number-to-words num)
      3  (str (get single-numbers (quot num 100))
              " hundred and "
              (number-to-words (rem num 100)))
      4  (str (get single-numbers (quot num 1000))
              " thousand "
              (number-to-words (rem num 1000))))))

