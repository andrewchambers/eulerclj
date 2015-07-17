
(defn sum [x] (reduce + x))
(defn multiple? [x y] (= 0 (mod x y)))
(defn prime? [x]
  (cond
    (< x 0) false
    (= x 1) true
    (= x 2) false
    :else
    (let [end (/ x 2)]
      (loop [i 3]
        (cond
          (> i end) true
          (multiple? x i) false
          :else (recur (+ x 2)))))))

(defn apply-until
  "While not (pred x) iterate on x = (f x) returning x"
  [x f pred]
    (loop [v x]
      (if (pred v)
        v
        (recur (f v)))))

(defn euler1
  []
  (sum (filter 
         #(or 
            (multiple? % 3)
            (multiple? % 5))
       (range 1 1000))))

(defn fib-seq 
  ([] (fib-seq 1 1))
  ([a b]
    (cons a (lazy-seq (fib-seq b (+ b a))))))

(defn euler2
  []
  (sum 
    (filter even? (take-while #(< % 4000000) (fib-seq)))))

(defn euler3
  []
  (loop [v 600851475143
         n 2]
    (if (= 1 v)
      (dec n)
      (recur (apply-until v #(quot % n) #(not= (mod % n) 0)) (inc n)))))
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
