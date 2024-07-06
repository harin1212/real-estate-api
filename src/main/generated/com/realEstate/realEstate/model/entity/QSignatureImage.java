package com.realEstate.realEstate.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSignatureImage is a Querydsl query type for SignatureImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSignatureImage extends EntityPathBase<SignatureImage> {

    private static final long serialVersionUID = 743284572L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSignatureImage signatureImage = new QSignatureImage("signatureImage");

    public final com.realEstate.realEstate.model.QBaseEntity _super = new com.realEstate.realEstate.model.QBaseEntity(this);

    public final QContract contract;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QSignatureImage(String variable) {
        this(SignatureImage.class, forVariable(variable), INITS);
    }

    public QSignatureImage(Path<? extends SignatureImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSignatureImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSignatureImage(PathMetadata metadata, PathInits inits) {
        this(SignatureImage.class, metadata, inits);
    }

    public QSignatureImage(Class<? extends SignatureImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.contract = inits.isInitialized("contract") ? new QContract(forProperty("contract"), inits.get("contract")) : null;
    }

}

