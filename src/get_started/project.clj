(ns get-started.project)
;Wordfinder Input: a m × n grid of letters and a word. Output: find the
;location(s) of the word in the grid (in columns, rows and diagonals), give the
;sequence of coordinates for the letters of the word.

;(wordfinder ["ahk" "pet" "klk" "ili" "pot"] "hello")
;([1 2] [2 2] [3 2] [4 2] [5 2])



;def (list, word);
;       m = len(list(0))
;       n = len(list)


(defn square
  [x]
  (x * x))



(count "apple")
(count (["ahk" "pet" "klk" "ili" "pot"] 1))










(defn wordfinder
  [list, word]
  ( (m = (count ((list) 1)))
   
    (n = (count(list)))
   
   if n > count(word)


   ))


(wordfinder ["ahk" "pet" "klk" "ili" "pot"] "hello")