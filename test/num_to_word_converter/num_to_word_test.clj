(ns num-to-word-converter.num-to-word-test
  (:require [clojure.test :refer :all]
            [num-to-word-converter.num-to-word :refer [convert-number-to-words]]))

(deftest single-digit-test
  (testing "returns single digits words"
    (is (= "one" (convert-number-to-words 1)))))

(deftest double-digit-number-test
  (testing "returns double digits words"
    (is (= "twenty one" (convert-number-to-words 21)))))

(deftest triple-digit-number-test
  (testing "returns triple digits words"
    (is (= "one hundred and five" (convert-number-to-words 105)))
    (is (= "one hundred and twenty three" (convert-number-to-words 123)))))

(deftest four-digit-number-test
  (testing "returns four digits words"
    (is (= "one thousand and five" (convert-number-to-words 1005)))
    (is (= "one thousand and forty two" (convert-number-to-words 1042)))))

(deftest greater-than-four-digit-number-test
  (testing "returns greater than four digits words"
    (is (= "fifty six million nine hundred and forty five thousand seven hundred and eighty one" (convert-number-to-words 56945781)))
    (is (= "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" (convert-number-to-words 999999999)))))
