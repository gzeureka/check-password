(ns check-password.core
  (:gen-class)
  (:require [buddy.core.hash :as hash]
            [buddy.core.codecs :as codecs]
            )
  )

(defn sha3-512 [s]
  (codecs/bytes->hex (hash/sha3-512 s)))

(defn get-salt-of-user [user-id]
  ; 注意：实际应用中，应该根据 user-id 从 DB 中获取 salt
  "5q3yhCdSDMj9Za9jJE0vhfExlTV8JeSe6XnfblAFkPY"
  )

(defn check-pw [user-id password ciphertext]
  (= (sha3-512 (str (get-salt-of-user user-id) password)) ciphertext)
  )

