package com.example.hellograder

fun main() {
    var overall = OverallResult()
//    println(overall.name)
//    println(overall.weight)

    var yearOne = YearResult(1,60.0,20.0)
//    println(yearOne.name)
//    println(yearOne.weight)

    var designModule = ModuleResult("Design",6.0)

    var designAssessment = AssessmentResult("Design Assessment",100.0,70.0)

    designModule.addResult(designAssessment)
    yearOne.addResult(designModule)
    overall.addResult(yearOne)

    println(overall.calculateAverage())
}