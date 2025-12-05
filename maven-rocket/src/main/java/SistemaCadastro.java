public class SistemaCadastro {
    public static void main(String[] args) {
        FabricaConexao.abrirConexao();

        Cadastro cadastro = new Cadastro();
        CadastroRepository repository = new CadastroRepository();
        cadastro.setNome("Maria");
        cadastro.setIdade(17);
        cadastro.setId(4);
        repository.alterar(cadastro);
    }
}
