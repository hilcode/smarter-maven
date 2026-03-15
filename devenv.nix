{ pkgs, lib, config, inputs, ... }:
{
    packages = with pkgs; [
        bash
        jjui
        jujutsu
        just
    ];

    languages.java = with pkgs; {
        enable = true;
        jdk.package = jdk11;
        lsp.enable = true;
        maven.enable = true;
    };
}
