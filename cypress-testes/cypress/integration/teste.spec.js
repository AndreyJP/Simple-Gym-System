/// <reference types="cypress"/>

const url = 'http://localhost:8080'

describe('Testes Funcionais de login no sistema', () => {
    
    before(() => {
        cy.visit(url)
    })

    it('Login inválido funcionário', () => {
        cy.get('.row > :nth-child(2)').click()
        cy.get('#usuario').type('admin')
        cy.get('#senha').type('teste')
        cy.get('.btn-dark').click()
        cy.get('#usuario').should('exist')
    })

    it('Login válido funcionário', () => {
        cy.get('#usuario').type('admin')
        cy.get('#senha').type('master')
        cy.get('.btn-dark').click()
        cy.get('.mt-4').should('exist')
    })

    it('Logout', () => {
        cy.get('#userDropdown').click()
        cy.get('.dropdown-item').click()
        cy.get('h1.text-center').should('exist')
    })
    
})

describe('Caso de Uso Manter Cadastro de Aluno', () =>{

    before(() => {
        cy.visit(url)
        cy.get('.row > :nth-child(2)').click()
        cy.get('#usuario').type('admin')
        cy.get('#senha').type('master')
        cy.get('.btn-dark').click()
    })

    it('Cadastro correto de alunos', () => {
        cy.get('[data-target="#collapseCadastros"]').click()
        cy.get('[href="/usuario/aluno"]').click()
        cy.get('.col-md-2 > a > .btn').click()
        cy.get('#nome').clear().type('Usuário Teste 1')
        cy.get('#cpf').clear().type('111.222.333-55')
        cy.get('#identidade').clear().type('MG 12.543.908')
        cy.get('#email').clear().type('usuario1@email.com')
        cy.get('#telefone').clear().type('(35) 3434-3434')
        cy.get('#celular').clear().type('(35) 9 9777-8888')
        cy.get('#login').clear().type('usuario1')
        cy.get('#senha').clear().type('master')
        cy.get('#connfirmarsenha').clear().type('master')
        cy.get('#rua').clear().type('Rua Teste 1')
        cy.get('#bairro').clear().type('Bairro Teste 1')
        cy.get('#uf').select('SP')
        cy.get('#cidade').clear().type('Cidade Teste 1')
        cy.get('#planopgto').select('1')
        cy.get('.btn-dark').click()
        cy.get('.card-body').should('contain', 'Usuário Teste 1')
    })

    it('Cadastro de alunos com campos obrigatórios em branco', () => {
        cy.get('[data-target="#collapseCadastros"]').click()
        cy.get('[href="/usuario/aluno"]').click()
        cy.get('.col-md-2 > a > .btn').click()
        cy.get('#nome').clear().type('Usuário Teste 2')
        cy.get('#cpf').clear().type('111.222.333-52')
        cy.get('#identidade').clear().type('MG 12.543.902')
        cy.get('#email').clear().type('usuario2@email.com')
        cy.get('#telefone').clear().type('(35) 3434-3432')
        cy.get('#celular').clear().type('(35) 9 9777-8882')
        cy.get('#login').clear()
        cy.get('#senha').clear().type('master')
        cy.get('#connfirmarsenha').clear()
        cy.get('#rua').clear().type('Rua Teste 2')
        cy.get('#bairro').clear().type('Bairro Teste 2')
        cy.get('#uf').select('MG')
        cy.get('#cidade').clear().type('Cidade Teste 2')
        cy.get('#planopgto').select('2')
        cy.get('.btn-dark').click()
        cy.get('.btn-dark').should('exist')
    })

    it('Cadastro de alunos repetidos', () => {
        cy.get('[data-target="#collapseCadastros"]').click()
        cy.get('[href="/usuario/aluno"]').click()
        cy.get('.col-md-2 > a > .btn').click()
        cy.get('#nome').clear().type('Usuário Teste 1')
        cy.get('#cpf').clear().type('111.222.333-55')
        cy.get('#identidade').clear().type('MG 12.543.908')
        cy.get('#email').clear().type('usuario1@email.com')
        cy.get('#telefone').clear().type('(35) 3434-3434')
        cy.get('#celular').clear().type('(35) 9 9777-8888')
        cy.get('#login').clear().type('usuario1')
        cy.get('#senha').clear().type('master')
        cy.get('#connfirmarsenha').clear().type('master')
        cy.get('#rua').clear().type('Rua Teste 1')
        cy.get('#bairro').clear().type('Bairro Teste 1')
        cy.get('#uf').select('SP')
        cy.get('#cidade').clear().type('Cidade Teste 1')
        cy.get('#planopgto').select('1')
        cy.get('.btn-dark').click()
        cy.get('.card-body').should('not.exist')
    })

    it('Excluir aluno', () => {
        cy.visit('http://localhost:8080/usuario/aluno')
        cy.get('#usuario').type('admin')
        cy.get('#senha').type('master')
        cy.get('.btn-dark').click()
        cy.get('[data-target="#collapseCadastros"]').click()
        cy.get('[href="/usuario/aluno"]').click()
        cy.get('.even > .text-center > .dropdown > #opcoes').click()
        cy.get('.even > .text-center > .dropdown > .dropdown-menu > [data-toggle="modal"]').click()
        cy.get('#modalExcluir19 > .modal-dialog > .modal-content > .modal-footer > a > .btn').click()
        cy.get('.card-body').should('not.contain', 'Usuário Teste 1')
    })
})

describe.only('Manter cadastro de instrutores', () => {

    before(()=> {
        cy.visit(url)
        cy.get('.row > :nth-child(2)').click()
        cy.get('#usuario').type('admin')
        cy.get('#senha').type('master')
        cy.get('.btn-dark').click()
    })

    it('Cadastro válido de instrutores', () => {
        cy.get('[data-target="#collapseCadastros"]').click()
        cy.get('[href="/usuario/instrutor"]').click()
        cy.get('.col-md-2 > a > .btn').click()
        cy.get('#nome').clear().type('Instrutor Teste 1')
        cy.get('#cpf').clear().type('111.222.333-44')
        cy.get('#identidade').clear().type('MG 12.543.754')
        cy.get('#email').clear().type('instrutor1@email.com')
        cy.get('#telefone').clear().type('(35) 3434-6666')
        cy.get('#celular').clear().type('(35) 9 9777-6666')
        cy.get('#login').clear().type('instrutor1')
        cy.get('#senha').clear().type('master')
        cy.get('#connfirmarsenha').clear().type('master')
        cy.get('#formacao').clear().type('Educação Física')
        cy.get('#tipoAula').select('musculacao')
        cy.get('.btn-dark').click()
        cy.get('.card-body').should('contain', 'Instrutor Teste 1')
    })

    it.only('Cadastro de instrutores com campos obrigatórios em branco', () => {
        cy.get('[data-target="#collapseCadastros"]').click()
        cy.get('[href="/usuario/instrutor"]').click()
        cy.get('.col-md-2 > a > .btn').click()
        cy.get('#nome').clear().type('Instrutor Teste 1')
        cy.get('#cpf').clear().type('111.222.333-44')
        cy.get('#identidade').clear()
        cy.get('#email').clear().type('instrutor1@email.com')
        cy.get('#telefone').clear()
        cy.get('#celular').clear().type('(35) 9 9777-6666')
        cy.get('#login').clear().type('instrutor1')
        cy.get('#senha').clear()
        cy.get('#connfirmarsenha').clear().type('master')
        cy.get('#formacao').clear().type('Educação Física')
        cy.get('#tipoAula').select('musculacao')
        cy.get('.btn-dark').click()
        cy.get('.btn-dark').should('exist')
    })

    it.only('Cadastro de instrutores repetidos', () => {
        cy.get('[data-target="#collapseCadastros"]').click()
        cy.get('[href="/usuario/instrutor"]').click()
    })
})