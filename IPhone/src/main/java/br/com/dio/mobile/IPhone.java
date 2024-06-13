package br.com.dio.mobile;

import br.com.dio.utils.Device;
import br.com.dio.utils.Internet;
import br.com.dio.utils.Music;

public class IPhone implements Music, Device, Internet {


    @Override
    public void ligar(String number) {
        System.out.println(number);
    }

    @Override
    public void atender() {

    }

    @Override
    public void iniciarCorreioVoz(String msg) {
        System.out.println(msg);
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println(url);
    }

    @Override
    public void adicionarNovaAba() {

    }

    @Override
    public void atualizaPagina() {

    }

    @Override
    public void tocar() {

    }

    @Override
    public void pausar() {

    }

    @Override
    public void selecionarMusica(String faixa) {
        System.out.println(faixa);
    }
}
