package br.com.backend.crud.messages;

public interface UsuarioMessage {

    //---   Processos   ---//
    String USUARIO_CADASTRO = "cadastrarUsuario";
    String USUARIO_ALTERACAO = "alterarUsuario";
    String USUARIO_CONSULTA = "consultarUsuario";
    String USUARIO_CONSULTA_POR_CODIGO = "consultarUsuarioPorCodigo";

    //---   Mensagens   ---//
    String USUARIO_CADASTRO_MENSAGEM = "Não foi possível cadastrar o usuário. Tente novamente mais tarde.";
    String USUARIO_CONSULTA_MENSAGEM = "Não foi possível consultar os usuários. Tente novamente mais tarde.";
    String USUARIO_ALTERACAO_MENSAGEM = "Não foi possível alterar as informações do Usuario: %s. Tente novament e mais tarde.";
    String USUARIO_CONSULTA_PAGINA_MENSAGEM = "Não foi possível consultar os %s usuários na pagina %s . Tente novamente mais tarde.";

    //---   Mensagens de log   ---//
    String LOG_USUARIO_NAO_PROCESSADO = "Requisição não processada. ## %s";
}
