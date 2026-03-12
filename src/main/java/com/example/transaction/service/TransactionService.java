
package com.example.transaction.service;

import com.example.transaction.dto.*;
import com.example.transaction.model.Transaction;
import com.example.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService{

 private final TransactionRepository repository;

 public TransactionService(TransactionRepository repository){
  this.repository=repository;
 }

 @Transactional
 public Transaction deposit(DepositRequest req){
  Transaction tx=new Transaction();
  tx.setAccountId(req.getAccountId());
  tx.setAmount(req.getAmount());
  tx.setType("DEPOSIT");
  tx.setStatus("SUCCESS");
  return repository.save(tx);
 }

 @Transactional
 public Transaction withdraw(WithdrawRequest req){
  Transaction tx=new Transaction();
  tx.setAccountId(req.getAccountId());
  tx.setAmount(req.getAmount());
  tx.setType("WITHDRAW");
  tx.setStatus("SUCCESS");
  return repository.save(tx);
 }

 @Transactional
 public Transaction transfer(TransferRequest req){
  Transaction tx=new Transaction();
  tx.setAccountId(req.getFromAccountId());
  tx.setReferenceAccountId(req.getToAccountId());
  tx.setAmount(req.getAmount());
  tx.setType("TRANSFER");
  tx.setStatus("SUCCESS");
  return repository.save(tx);
 }
}
