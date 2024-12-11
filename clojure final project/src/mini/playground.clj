(ns mini.playground)

; This project has custom configuration.
; See .vscode/settings.json

; If you are new to Calva, you may want to use the command:
; Calva: Create a “Getting Started” REPL project
; which creates a project with a an interactive Calva (and Clojure) guide.



;Wordfinder Input: a m × n grid of letters and a word. Output: find the
;location(s) of the word in the grid (in columns, rows and diagonals), give the
;sequence of coordinates for the letters of the word.

;(wordfinder ["ahk" "pet" "klk" "ili" "pot"] "hello")
;([1 2] [2 2] [3 2] [4 2] [5 2])



; grid　n*m
(def grid ["ahk"
           "pet"
           "klk"
           "ili"
           "pot"])

; target word
(def target-word "hello")


;fisrst letter
(first "hellop")


;(nth grid r)  n行目のraw
;c番目の文字
(defn get-char [grid r c]
  (when (and (>= r 0)
             (< r (count grid))
             (>= c 0)
             (< c (count (grid r))))
    (nth (nth grid r) c)))



(defn find_first_letter [grid, target]
  (let [first_letter (first target)]
   (for [raw (range (count grid))
         colum (range (count (grid raw)))
         :when (= (get-char grid raw colum) first_letter)]  ;ここがtrueの時だけ
     [raw colum])))
(find_first_letter grid "hello")

(find_first_letter grid "eye")





;for [n ]

(defn find_last_letter [grid, target]
  (let [last_letter (last target)]
    (for [raw (range (count grid))
          colum (range (count (grid raw)))
          :when (= (get-char grid raw colum) last_letter)]  ;ここがtrueの時だけ
      [raw colum])))

(find_last_letter grid "hello")


(def directions [[-1 0]  ; 上
                 [1 0]   ; 下
                 [0 -1]  ; 左
                 [0 1]   ; 右
                 [-1 -1] ; 左上
                 [-1 1]  ; 右上
                 [1 -1]  ; 左下
                 [1 1]]) ; 右下




(defn check_word_match [grid target-word start-row start-col direction]
  (let [current-char (get-char grid start-row start-col)      ;; 現在のセルの文字
        expected-char (first target-word)]
    (if (or (nil? current-char) (not= current-char expected-char))
      false
      (if (= (count target-word) 1)
        true
        (let [next-row (+ start-row (first direction))
              next-col (+ start-col (second direction))]
          (check_word_match grid (rest target-word) next-row next-col direction))))))

(check_word_match grid "pet" 1 0 [0 1])
(check_word_match grid "pet" 1 0 [-1 0])
(check_word_match grid "pot" 1 2 [1 0])
(check_word_match grid "pli" 1 0 [1 1])

;; リストを作るにだ
(defn find_word_make_list [grid target-word start-row start-col direction]
  (letfn [(find [raw col remaining list]
            (if (empty? remaining)
              list
              (let [current-char (get-char grid raw col)]
                (if (or (nil? current-char) (not= current-char (first remaining)))
                  nil
                  (find (+ raw (first direction))
                              (+ col (second direction))
                              (rest remaining)
                              (conj list [raw col]))))))]
    (find start-row start-col target-word [])))


(find_word_make_list grid "pet" 1 0 [0 1])
(find_word_make_list grid "pot" 2 2 [1 0])
(find_word_make_list grid "hello" 0 1 [1 0])





(def grid ["ahk"
           "pet"
           "klk"
           "ili"
           "pot"])



