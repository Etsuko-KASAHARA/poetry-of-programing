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



;def (list, word);
;       m = len(list(0))
;       n = len(list)


;mの値　横の文字の数



(def m (count (["ahk" "pet" "klk" "ili" "pot"] 1)))

;nの値　縦の文字の数

(def n (count ["ahk" "pet" "klk" "ili" "pot"]))

; grid　n*m
(def grid ["ahk"
           "pet"
           "klk"
           "ili"
           "pot"])

; target word
(def target "hello")


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

;(def grid ["abc" "def" "ghi"])
;b
(get-char grid 0 1) 
;i
(get-char grid 2 2) 

(get-char grid 3 2)

(get-char grid 0 0)
;nill
(get-char grid -1 0) 

(second "hello")


(last "hello" )


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

def