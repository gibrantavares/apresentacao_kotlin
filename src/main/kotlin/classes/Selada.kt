package classes

sealed class Funcionario(val nome: String, val salario: Double)

class Gerente(nome: String, salario: Double, val senha: String) : Funcionario(nome, salario)
class Vendedor(nome: String, salario: Double, val gerente: Gerente) : Funcionario(nome, salario)

private fun detalhar(f: Funcionario): String {
    return when (f) {
        is Gerente -> "Nome: ${f.nome}; Salário: ${f.salario}; Senha: ${f.senha}"
        is Vendedor -> "Nome: ${f.nome}; Salário: ${f.salario}; Gerente: ${f.gerente.nome}"
    }
}

fun main() {
    println(detalhar(Gerente("Maria", 2000.0, "qwerty")))
}