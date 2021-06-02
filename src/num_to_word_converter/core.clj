(ns num-to-word-converter.core)

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

(defn num->digits-count
  "Converts a number to a digit and gives the count"
  [num]
  (->> (str num)
       seq
       (map str)
       (map read-string)
       count))

(defn get-quotient [{:keys [number divisor remainder]}]
  (if divisor
    (quot number divisor)
    (rem num remainder)))

(defn number-to-words
  "Divide number if greater than nineteen"
  [num]
  (if (> num 19)
    (str (get multiples-of-ten (get-quotient  {:number num
                                               :divisor 10}))
         (get single-numbers (get-quotient  {:number num
                                             :reminder 10})))
    (get single-numbers num)))

(defn convert-number-to-words
  [num]
  (let [number-count (num->digits-count num)]
    (case number-count
      (or 1 2) (number-to-words num)
      3  (str (get single-numbers (get-quotient {:number num
                                                 :divisor 100}))
              " hundred and "
              (number-to-words (get-quotient  {:number num
                                               :reminder 100})))
      4  (str (get single-numbers (get-quotient {:number num
                                                 :divisor 1000}))
              " thousand "
              (number-to-words  (get-quotient {:number num
                                               :reminder 1000}))))))

