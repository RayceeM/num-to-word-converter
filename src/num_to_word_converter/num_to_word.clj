(ns num-to-word-converter.num-to-word)

(def single-numbers
  {0 "zero"
   1 "one"
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
   "forty "
   "fifty "
   "sixty "
   "seventy "
   "eighty "
   "ninety "])

(def greater-multiples ["thousand "
                        "million "
                        "billion"
                        "trillion "])

(defn num->digits-count
  "Converts a number to a digit and gives the count"
  [num]
  (->> num
       (str)
       (map int)
       (map #(- % (int \0)))
       (into [])
       count))

(defn get-quotient [{:keys [number divisor remainder]}]
  (cond
    divisor (quot number divisor)
    remainder (rem number remainder)
    :else number))

(defn number-to-words
  "Divide number if greater than nineteen"
  [num]
  (if (> num 19)
    (str (get multiples-of-ten (get-quotient {:number num
                                              :divisor 10}))
         (when-not (= 0  (get-quotient {:number num
                                        :remainder 10}))
           (get single-numbers (get-quotient {:number num
                                              :remainder 10}))))
    (get single-numbers num)))

(defn convert-number-to-words
  [num]
  (let [number-count (num->digits-count num)]
    (case number-count
      (or 1 2) (number-to-words num)
      3  (str (get single-numbers (get-quotient {:number num
                                                 :divisor 100}))
              " hundred "
              (when-not (= 0 (get-quotient {:number num
                                             :remainder 100}))
                (str "and "
                     (number-to-words (get-quotient  {:number num
                                                      :remainder 100})))))
      (loop [word []
             num num
             multiple -1]
        (if (zero? num)
          (apply str word)
          (let [reminder-num (get-quotient {:number num
                                            :remainder 1000})
                num (get-quotient {:number num
                                   :divisor 1000})
                word (if (zero? reminder-num)
                       word ;; return empy vector if number is zero
                       (let [num->word (convert-number-to-words reminder-num)]
                         (cons
                          (if (neg? multiple)
                            (if (< reminder-num 100)
                              (str "and " num->word)
                              num->word)
                            (str num->word " " (greater-multiples multiple)))
                          word)))]
            (recur word num (inc multiple))))))))