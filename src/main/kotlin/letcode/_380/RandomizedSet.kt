package br.com.lucolimac.letcode._380

class RandomizedSet() {
    private val dataset = mutableSetOf<Int>()

    fun insert(`val`: Int): Boolean {
        if (dataset.contains(`val`)) {
            return false
        }
        dataset.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        return if (dataset.contains(`val`)) {
            dataset.remove(`val`)
            true
        } else {
            false
        }
    }

    fun getRandom(): Int {
        Int.MIN_VALUE
        return dataset.random()
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */
