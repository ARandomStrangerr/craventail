package main.product.repository;

import org.springframework.stereotype.Repository;

import main.product.entity.TaiKhoanDungEntity;

@Repository
public interface TaiKhoanDungRepo extends BaseRepo<TaiKhoanDungEntity, Long> {
}
