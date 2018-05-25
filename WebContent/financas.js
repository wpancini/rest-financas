function criacaoDeTarefa_acessar()
{
    location.href = "cadastrotipolancamento.html";
}

function criacaoDeTarefa_excluirConcluidas()
{
    // URL: Carlos definirá no webinar #2
    
    location.href = "";
}

function criacaoDeTarefa_cancelar()
{
    location.href = "BlueTasks-ListaDeTarefas.html";
}

function criacaoDeTarefa_validar()
{
    var tarefa = document.forms["formularioCadastroTarefa"].descricaoTarefa.value;
    
    if(tarefa.length < 3)
    {
        alert('A descrição da tarefa deve conter pelo menos 3 caracteres.');
        return;
    }
    
    if(tarefa.length > 10)
    {
        alert('A descrição da tarefa deve conter no máximo 10 caracteres.');
        return;
    }
    
    document.forms["formularioCadastroTarefa"].submit();
}