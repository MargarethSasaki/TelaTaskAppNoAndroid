package br.fzlbpms.taskappnoandroid.model.Tarefa

class Tarefa(nome:String, detalhes: String?, createdDate: Date, pzoFinal: Date) {

    var status = 0.0
        get() {return field}
        set(value) {
            field = value
        }

}