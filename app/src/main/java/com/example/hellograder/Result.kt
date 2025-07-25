package com.example.hellograder

open class Result (val name: String, var credits: Double? = null, var weight: Double? = null, var average: Double? = null){
    var complete: Double = 0.0 // Percentage of result completed.
    var goals: List<Int> = mutableListOf(70,60,50,40) // List of goals.
    var unitResults = mutableListOf<Result>() // List of results.

    fun calculateAverage(): Double? {
        if (average == null) {
            println("Current Calc: ${this.name}")
            var weightedSum: Double = 0.0 // Weighted cumulative sum.
            var totalWeight: Double = 0.0 // Total weight.
            for (result in unitResults) {
                println(result.name)
                //println("${result.name}: ${result.calculateAverage()}")
                var resultAverage = result.calculateAverage()
                println(resultAverage)
                println(result.weight)
                if (resultAverage != null && result.weight != null) {
                    weightedSum += resultAverage * result.weight!!
                    totalWeight += result.weight!!
                }
                else
                    return null
                println(weightedSum)
            }
            this.average = weightedSum / totalWeight
            println("Final value (${this.name}): ${this.average}")
            return this.average
        }
        else
            return average
    }

    fun calculateComplete(): Double? {
        var completeSum: Double = 0.0 // Completeness cumulative sum.
        for (result in unitResults) {
            completeSum += result.calculateComplete()?.let { result.weight?.times(it) } ?: return null
        }
        return completeSum / 100
    }

    fun addResult(result: Result) {
        // Calculate weight before adding.
//        println("Result Weight (${result.name}): ${result.weight}")
        if (result.weight == null)
//            println(result.credits)
//            println(this.credits)
            if (result.credits != null && this.credits != null) {
                result.weight = result.credits!! / this.credits!!
            }
        // Add result.
//        println("Final Weight (${result.name}): ${result.weight}")
        this.unitResults.add(result)
    }
}

class OverallResult: Result("Overall", weight = 100.0) {
}

class YearResult(year: Int, credits: Double, weight: Double): Result("Year $year", credits, weight) {
}

class ModuleResult(name: String, credits: Double): Result(name, credits) {
}

class AssessmentResult(name: String, weight: Double, average: Double): Result(name, weight = weight, average = average) {
}