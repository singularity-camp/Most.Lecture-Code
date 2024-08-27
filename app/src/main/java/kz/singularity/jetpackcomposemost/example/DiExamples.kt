package kz.singularity.jetpackcomposemost.example

class ClassB {
    var classC: ClassC




    constructor(classC: ClassC){
        this.classC = classC
    }

    fun someMethod() {

    }
}

open class ClassC {
    constructor(){
    }

    open fun hello() {
        println("Hello")
    }
}

open class ClassCa : ClassC() {
    override fun hello() {
        println("Bojour")
    }
}

open class ClassCb: ClassC() {
    override fun hello() {
        println("Salam")
    }
}

class UserClass(){
    fun doSomething(){
        val classC = ClassCb()

        val classB = ClassB(classC);
        classB.someMethod();
    }

    fun doSomethingElse() {

    }
}

class SomeUserClass(){
    fun doSomething(){
        val classC = ClassCb()

        val classB = ClassB(classC);
        classB.someMethod();
    }
}

class AnotherUserClass(){
    fun doSomething(){
        val classC = ClassCb()

        val classB = ClassB(classC);
        classB.someMethod();
    }
}
