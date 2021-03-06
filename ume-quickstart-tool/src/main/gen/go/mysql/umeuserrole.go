package dto
import (
    "database/sql"
    ."gear/orm"
)

// 'UME用户角色关系表'表实体结构(基础类型描述)
type UmeUserRoleDto struct {
    // 用户ID
    UserId string
    // 用户持有角色ID
    RoleId string
    // 创建者
    CreateAuthor string
    // 创建时间
    CreateDatetime string
    // 更新者
    UpdateAuthor string
    // 更新时间
    UpdateDatetime string
}

// 'UME用户角色关系表'表实体结构(SQL类型描述)
type UmeUserRoleEntity struct {
    // 用户ID 
    UserId sql.NullString `name:"USER_ID", type:"VARCHAR", comment:"用户ID", key:true, notnull:true`
    // 用户持有角色ID 
    RoleId sql.NullString `name:"ROLE_ID", type:"VARCHAR", comment:"用户持有角色ID", key:true, notnull:true`
    // 创建者
    CreateAuthor sql.NullString `name:"CREATE_AUTHOR",  type:"VARCHAR", comment:"创建者", key:false, notnull:false`
    // 创建时间
    CreateDatetime sql.NullString `name:"CREATE_DATETIME",  type:"TIMESTAMP", comment:"创建时间", key:false, notnull:false`
    // 更新者
    UpdateAuthor sql.NullString `name:"UPDATE_AUTHOR",  type:"VARCHAR", comment:"更新者", key:false, notnull:false`
    // 更新时间
    UpdateDatetime sql.NullString `name:"UPDATE_DATETIME",  type:"TIMESTAMP", comment:"更新时间", key:false, notnull:false`
}

// 返回'UME用户角色关系表'表名
func (owner *UmeUserRoleEntity) TableName() string {
    return "UME_USER_ROLE"
}

// 从'map'创建
func (owner *UmeUserRoleEntity) FromMap(src map[string]interface{}) *UmeUserRoleEntity {
    var value interface{}
    var exist bool
    value,exist = src["UserId"]
    if exist {
        owner.UserId = sql.NullString{String:value.(string), Valid:true}
    }
    value,exist = src["RoleId"]
    if exist {
        owner.RoleId = sql.NullString{String:value.(string), Valid:true}
    }
    value,exist = src["CreateAuthor"]
    if exist {
        owner.CreateAuthor = sql.NullString{String:value.(string), Valid:true}
    }
    value,exist = src["CreateDatetime"]
    if exist {
        owner.CreateDatetime = sql.NullString{String:value.(string), Valid:true}
    }
    value,exist = src["UpdateAuthor"]
    if exist {
        owner.UpdateAuthor = sql.NullString{String:value.(string), Valid:true}
    }
    value,exist = src["UpdateDatetime"]
    if exist {
        owner.UpdateDatetime = sql.NullString{String:value.(string), Valid:true}
    }
    return owner
}

// 变换为'map'
func (owner *UmeUserRoleEntity) ToMap() map[string]interface{} {
    tar := make(map[string]interface{})
    if owner.UserId.Valid {
        tar["UserId"] = owner.UserId.String
    }
    if owner.RoleId.Valid {
        tar["RoleId"] = owner.RoleId.String
    }
    if owner.CreateAuthor.Valid {
        tar["CreateAuthor"] = owner.CreateAuthor.String
    }
    if owner.CreateDatetime.Valid {
        tar["CreateDatetime"] = owner.CreateDatetime.String
    }
    if owner.UpdateAuthor.Valid {
        tar["UpdateAuthor"] = owner.UpdateAuthor.String
    }
    if owner.UpdateDatetime.Valid {
        tar["UpdateDatetime"] = owner.UpdateDatetime.String
    }
    return tar
}

// 从'UmeUserRoleDto'创建
func (owner *UmeUserRoleEntity) FromDto(src UmeUserRoleDto) *UmeUserRoleEntity {
    owner.UserId = sql.NullString{String:src.UserId, Valid:true}
    owner.RoleId = sql.NullString{String:src.RoleId, Valid:true}
    owner.CreateAuthor = sql.NullString{String:src.CreateAuthor, Valid:true}
    if src.CreateDatetime != "" {
        owner.CreateDatetime = sql.NullString{String:src.CreateDatetime, Valid:true}
    }
    owner.UpdateAuthor = sql.NullString{String:src.UpdateAuthor, Valid:true}
    if src.CreateDatetime != "" {
        owner.UpdateDatetime = sql.NullString{String:src.UpdateDatetime, Valid:true}
    }
    return owner
}

// 变换为'UmeUserRoleDto'
func (owner *UmeUserRoleEntity) ToDto() UmeUserRoleDto {
    var tar UmeUserRoleDto
    tar.UserId = owner.UserId.String
    tar.RoleId = owner.RoleId.String
    tar.CreateAuthor = owner.CreateAuthor.String
    tar.CreateDatetime = owner.CreateDatetime.String
    tar.UpdateAuthor = owner.UpdateAuthor.String
    tar.UpdateDatetime = owner.UpdateDatetime.String
    return tar
}

// 创建行数据映射列表
func (owner *UmeUserRoleEntity) Mapper(entity interface{}) []interface{} {
    e := entity.(*UmeUserRoleEntity)
    return []interface{}{ &e.UserId,&e.RoleId,&e.CreateAuthor,&e.CreateDatetime,&e.UpdateAuthor,&e.UpdateDatetime}
}

// 查询
func (owner *UmeUserRoleEntity) Retrieve(ctx OrmContext, orderBy ...OrderByCondition) []UmeUserRoleEntity {
    sqlText, sqlParams := GetDao().BuildSqlSelect(owner, orderBy)
    var nl []UmeUserRoleEntity
    GetDao().Retrieve(ctx, sqlText, sqlParams[:]...).Mapping(&nl, owner.Mapper)
    return nl
}

// 查询(使用map类型参数查询)
func (owner *UmeUserRoleEntity) RetrieveByMap(ctx OrmContext, param map[string]interface{}, orderBy ...OrderByCondition) []UmeUserRoleEntity {
    return owner.FromMap(param).Retrieve(ctx,orderBy[:]...)
}

// 统计
func (owner *UmeUserRoleEntity) Count(ctx OrmContext) int64 {
    sqlText, sqlParams := GetDao().BuildSqlCount(owner)
    return GetDao().Count(ctx, sqlText, sqlParams[:]...)
}

// 登录
func (owner *UmeUserRoleEntity) Insert(ctx OrmContext) int64 {
    sqlText, sqlParams := GetDao().BuildSqlInsert(owner)
    return GetDao().Insert(ctx, sqlText, sqlParams[:]...)
}

// 更新
func (owner *UmeUserRoleEntity) Update(ctx OrmContext) int64 {
    sqlText, sqlParams := GetDao().BuildSqlUpdate(owner)
    return GetDao().Update(ctx, sqlText, sqlParams[:]...)
}

// 删除
func (owner *UmeUserRoleEntity) Delete(ctx OrmContext) int64 {
    sqlText, sqlParams := GetDao().BuildSqlDelete(owner)
    return GetDao().Delete(ctx, sqlText, sqlParams[:]...)
}







